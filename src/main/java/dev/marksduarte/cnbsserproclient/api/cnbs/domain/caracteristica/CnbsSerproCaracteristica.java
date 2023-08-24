package dev.marksduarte.cnbsserproclient.api.cnbs.domain.caracteristica;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class CnbsSerproCaracteristica {
    private String codigoCaracteristica;
    private String codigoValorCaracteristica;
    private Long numeroCaracteristica;

    private String nomeCaracteristica;
    private String nomeValorCaracteristica;
    private String siglaUnidadeMedida;

    private Boolean caracteristicaObrigatoria;
    private Boolean statusCaracteristica;
    private Boolean statusValorCaracteristica;

    private List<CnbsSerproValorCaracteristica> valorCaracteristica;

}
