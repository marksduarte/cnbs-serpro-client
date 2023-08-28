package dev.marksduarte.cnbsserproclient.api.cnbs;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.caracteristica.CnbsSerproCaracteristica;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.item.CnbsSerproItem;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.material.CnbsSerproClassificacaoContabilMaterial;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.material.CnbsSerproMaterial;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.servico.CnbsSerproClassificacaoContabilServico;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.servico.CnbsSerproServico;
import dev.marksduarte.cnbsserproclient.exception.CnbsSerproException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class CnbsSerproService {

    protected static final String API_INDISPONIVEL = "API CNBS SERPRO indisponível.";
    protected static final String API_ERRO_CONSULTA = "Erro ao consultar a API CNBS SEPRO.";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Lista de Materiais e Serviços resumidos.
     *
     * @param searchFilter a URL de itens é obrigatória.
     * @return {@link List} de {@link CnbsSerproItem}
     */
    public List<CnbsSerproItem> getItens(CnbsSerproSearchFilter searchFilter) {
        return this.callAPI(searchFilter.getUrlItens(), CnbsSerproItem.class);
    }

    /**
     * Pesquisar por código: Lista de Materiais com características ativos e sem suspensão. <br>
     * Pesquisar por palavra: Lista de Materiais ativos e sem suspensão.
     *
     * @param searchFilter a URL de materiais é obrigatória.
     * @return {@link List} de {@link CnbsSerproMaterial}
     */
    public List<CnbsSerproMaterial> getMateriais(CnbsSerproSearchFilter searchFilter) {
        return this.callAPI(searchFilter.getUrlMaterial(), CnbsSerproMaterial.class);
    }

    /**
     * Lista de Serviços ativos e sem suspensão.
     *
     * @param searchFilter a URL de serviços é obrigatória.
     * @return {@link List} de {@link CnbsSerproServico}
     */
    public List<CnbsSerproServico> getServicos(CnbsSerproSearchFilter searchFilter) {
        return this.callAPI(searchFilter.getUrlServico(), CnbsSerproServico.class);
    }

    /**
     * Pesquisar por código: Lista de Materiais com características ativos e sem suspensão. <br>
     * Pesquisar por palavra: Lista de Materiais ativos e sem suspensão.
     *
     * @param searchFilter a URL de materiais é obrigatória.
     * @return {@link List} de {@link CnbsSerproMaterial}
     */
    public List<CnbsSerproMaterial> getMateriaisPorPdm(CnbsSerproSearchFilter searchFilter) {
        return this.callAPI(searchFilter.getUrlMaterialPorPdm(), CnbsSerproMaterial.class);
    }

    /**
     * Lista de Classificações Contábeis de Material.
     *
     * @param searchFilter a URL de classificação contábil é obrigatória.
     * @return {@link List} de {@link CnbsSerproClassificacaoContabilMaterial}
     */
    public List<CnbsSerproClassificacaoContabilMaterial> getClassificacoesContabeisMaterial(CnbsSerproSearchFilter searchFilter) {
        return this.callAPI(searchFilter.getUrlClassificacaoContabilMaterial(), CnbsSerproClassificacaoContabilMaterial.class);
    }

    /**
     * Lista de Classificações Contábeis de Serviços.
     *
     * @param searchFilter a URL de classificação contábil é obrigatória.
     * @return {@link List} de {@link CnbsSerproClassificacaoContabilServico}
     */
    public List<CnbsSerproClassificacaoContabilServico> getClassificacoesContabeisServico(CnbsSerproSearchFilter searchFilter) {
        return this.callAPI(searchFilter.getUrlClassificacaoContabilServico(), CnbsSerproClassificacaoContabilServico.class);
    }

    public List<CnbsSerproCaracteristica> getCaracteristicasPorPdm(CnbsSerproSearchFilter searchFilter) {
        return this.callAPI(searchFilter.getUrlCaracteristicasPorPdm(), CnbsSerproCaracteristica.class);
    }

    private <T> List<T> callAPI(String url, Class<T> responseType) {
        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            var listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, responseType);
            var objType = objectMapper.getTypeFactory().constructType(responseType);

            String json = restTemplate.getForObject(url, String.class);
            if (json == null)
                return List.of();

            var response = json.trim().startsWith("[")
                    ? objectMapper.readValue(json, listType)
                    : objectMapper.readValue(json, objType);

            if (response instanceof ArrayList responseList)
                return responseList;

            return List.of((T) response);
        } catch (CnbsSerproException e) {
            throw e;
        } catch (RestClientException e) {
            throw new CnbsSerproException(API_INDISPONIVEL, e);
        } catch (Exception e) {
            throw new CnbsSerproException(API_ERRO_CONSULTA, e);
        }
    }

}
