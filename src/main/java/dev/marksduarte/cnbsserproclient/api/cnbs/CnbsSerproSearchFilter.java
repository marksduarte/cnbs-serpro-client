package dev.marksduarte.cnbsserproclient.api.cnbs;

import dev.marksduarte.cnbsserproclient.utils.BeanUtils;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CnbsSerproSearchFilter {
    private static final String REGEX_CODIGO = "^\\d+$";
    private static final String MENSAGEM_CODIGO_INVALIDO = "O código só deve conter números.";

    CnbsSerproProperties apiProperties = BeanUtils.getBean(CnbsSerproProperties.class);

    private String palavra;
    @Pattern(regexp = REGEX_CODIGO, message = MENSAGEM_CODIGO_INVALIDO)
    private String codigo;
    @Pattern(regexp = REGEX_CODIGO, message = MENSAGEM_CODIGO_INVALIDO)
    private String codigoPdm;

    public String getUrlMaterial() {
        if (StringUtils.isNotBlank(palavra))
            return apiProperties.getUrlMaterialPorPalavra(palavra);
        if (StringUtils.isNotBlank(codigo))
            return apiProperties.getUrlMaterialPorCodigo(codigo);
        throw new IllegalArgumentException("Nenhum argumento informado para a consulta de Material");
    }

    public String getUrlServico() {
        if (StringUtils.isNotBlank(palavra))
            return apiProperties.getUrlServicoPorPalavra(palavra);
        if (StringUtils.isNotBlank(codigo))
            return apiProperties.getUrlServicoPorCodigo(codigo);
        throw new IllegalArgumentException("Nenhum argumento informado para a consulta de Serviço.");
    }

    public String getUrlClassificacaoContabilMaterial() {
        if (StringUtils.isNotBlank(codigoPdm))
            return apiProperties.getUrlMaterialClassificacaoContabilPorPdm(codigoPdm);
        throw new IllegalArgumentException("Código Pdm não informado para a consulta de Classificação Contábil de Material.");
    }

    public String getUrlClassificacaoContabilServico() {
        if (StringUtils.isNotBlank(codigo))
            return apiProperties.getUrlServicoClassificacaoContabilPorCodigo(codigo);
        throw new IllegalArgumentException("Código Serviço não informado para a consulta de Classificação Contábil de Serviço.");
    }

    public String getUrlItens() {
        if (StringUtils.isNotBlank(palavra))
            return apiProperties.getUrlItemPorPalavra(palavra);
        throw new IllegalArgumentException("Nenhum argumento informado para a consulta de Itens.");

    }

    public String getUrlMaterialPorPdm() {
        if (StringUtils.isNotBlank(codigoPdm))
            return apiProperties.getUrlMaterialCaracteristicaValorPorPDM(codigoPdm);
        throw new IllegalArgumentException("Código Pdm não informado para a consulta de Materiais por Pdm.");
    }

    public String getUrlCaracteristicasPorPdm() {
        if (StringUtils.isNotBlank(codigoPdm))
            return apiProperties.getUrlCaracteristicasPorPDM(codigoPdm);
        throw new IllegalArgumentException("Código Pdm não informado para a consulta de Características por Pdm.");
    }

}
