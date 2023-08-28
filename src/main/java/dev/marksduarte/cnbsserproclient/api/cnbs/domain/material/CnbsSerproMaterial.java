package dev.marksduarte.cnbsserproclient.api.cnbs.domain.material;


import dev.marksduarte.cnbsserproclient.api.cnbs.domain.CnbsSerpro;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.caracteristica.CnbsSerproCaracteristica;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;


@Getter
@Setter
@Accessors(chain = true)
public class CnbsSerproMaterial extends CnbsSerpro {
    /*
    RETORNO API POR PALAVRA
    "codigoPdm": 5692,
    "codigoClasse": 6520,
    "codigoGrupo": 65,
    "descricaoPDM": "Conjunto acadêmico uso odontológico",
    "nomePdm": "Conjunto acadêmico uso odontológico",
    "descricaoClasse": "Instrumentos, equipamentos e suprimentos dentários",
    "nomeClasse": "Instrumentos, equipamentos e suprimentos dentários",
    "descricaoGrupo": "Equipamentos e artigos para uso médico, dentário e veteriná-rio",
    "statusPDM": true,
    "statusClasse": true,
    "statusGrupo": true
     */

    /*
    RETORNO API POR CÓDIGO
    "codigoPdm": 14640,
    "codigoItem": 602019,
    "nomePdm": "Peças E Componentes-Ordenhadeira Mecânica",
    "statusItem": true,
    "itemSuspenso": false,
    "itemSustentavel": false,
    "itemExclusivoUasgCentral": false,
    "codigoClasse": 3730,
    "buscaItemCaracteristica": []
     */
    private Long codigoPdm;
    private Long codigoItem;

    private String nomePdm;
    private String descricaoPdm;
    private String descricaoClasse;
    private String descricaoGrupo;

    private Boolean statusPdm;
    private Boolean statusClasse;
    private Boolean statusItem;
    private Boolean itemSuspenso;
    private Boolean itemSustentavel;
    private Boolean itemExclusivoUasgCentral;

    private List<CnbsSerproCaracteristica> buscaItemCaracteristica;

}
