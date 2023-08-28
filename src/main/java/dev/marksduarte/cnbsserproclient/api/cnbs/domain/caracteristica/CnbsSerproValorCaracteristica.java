package dev.marksduarte.cnbsserproclient.api.cnbs.domain.caracteristica;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CnbsSerproValorCaracteristica {
    private String codigoValorCaracteristica;
    private String numeroCaracteristica;

    private String nomeValorCaracteristica;
    private String siglaUnidadeMedida;

    private Boolean statusValorCaracteristica;
    private Boolean statusValorCaracteristicaPdm;

}
