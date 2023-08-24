package dev.marksduarte.cnbsserproclient.api.cnbs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "cnbs-serpro")
public class CnbsSerproProperties implements Serializable {
    private String url;
    private String urlItemPorPalavra;

    private String urlMaterial;
    private String urlMaterialPorCodigo;
    private String urlMaterialPorPalavra;
    private String urlMaterialCaracteristicaValorPorPDM;
    private String urlMaterialClassificacaoContabilPorPdm;

    private String urlCaracteristicasPorPDM;

    private String urlServico;
    private String urlServicoPorCodigo;
    private String urlServicoPorPalavra;
    private String urlServicoClassificacaoContabilPorCodigo;

    public String getUrlMaterialPorCodigo(String codigo) {
        return this.getUrlMaterialPorCodigo() + codigo;
    }

    public String getUrlMaterialPorPalavra(String palavra) {
        return getUrlMaterialPorPalavra() + palavra;
    }

    public String getUrlServicoPorCodigo(String codigo) {
        return this.getUrlServicoPorCodigo() + codigo;
    }

    public String getUrlServicoPorPalavra(String palavra) {
        return getUrlServicoPorPalavra() + palavra;
    }

    public String getUrlServicoClassificacaoContabilPorCodigo(String codigo) {
        return getUrlServicoClassificacaoContabilPorCodigo() + codigo;
    }

    public String getUrlMaterialClassificacaoContabilPorPdm(String codigo) {
        return getUrlMaterialClassificacaoContabilPorPdm() + codigo;
    }

    public String getUrlItemPorPalavra(String palavra) {
        return getUrlItemPorPalavra() + palavra;
    }

    public String getUrlMaterialCaracteristicaValorPorPDM(String codigo) {
        return getUrlMaterialCaracteristicaValorPorPDM() + codigo;
    }

    public String getUrlCaracteristicasPorPDM(String codigo) {
        return getUrlCaracteristicasPorPDM() + codigo;
    }
}
