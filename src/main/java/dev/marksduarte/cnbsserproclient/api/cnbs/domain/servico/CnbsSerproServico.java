package dev.marksduarte.cnbsserproclient.api.cnbs.domain.servico;

import dev.marksduarte.cnbsserproclient.api.cnbs.domain.CnbsSerpro;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CnbsSerproServico extends CnbsSerpro {
    /*
    RETORNO API POR PALAVRA
    "codigoSessao": 8,
        "nomeSessao": "Serviços de arquitetura, desenhos técnicos, pesquisa e desenvolvimento, negócio e produção",
        "statusSessao": true,
        "codigoDivisao": 87,
        "nomeDivisao": "Serviços de manutenção,reparo e instalação(exceto da construção)",
        "statusDivisao": true,
        "codigoGrupo": 871,
        "nomeGrupo": "Serviços de manutenção e reparo de produtos fabricados de metal,maquinaria e equipamentos",
        "statusGrupo": true,
        "codigoClasse": 8715,
        "nomeClasse": "Serviços de manutenção e reparo de outras maquinarias e equipamentos",
        "statusClasse": true,
        "codigoSubclasse": 0,
        "nomeSubclasse": null,
        "statusSubclasse": false,
        "codigoCPC": 8715,
        "codigo": 8869,
        "nomeServicoAcentuado": "Manutenção de carrossel transportador de bagagem",
        "status": true,
        "codigoServico": 8869,
        "descricaoServicoAcentuado": "Manutenção de carrossel transportador de bagagem",
        "statusServico": true,
        "indicadoItemSuspenso": false,
        "suspenso": false,
        "exclusivoCentralCompras": false
     */

    /*
    RETORNO API POR CÓDIGO
    "codigoServico": 2402,
    "statusServico": true,
    "codigoGrupo": 871,
    "nomeGrupo": "Serviços De Manutenção E Reparo De Produtos Fabricados De Metal,Maquinaria E Equipamentos",
    "descricaoServicoAcentuado": "Manutenção de Válvulas e Atuadores",
    "exclusivoCentralCompras": false,
    "suspenso": false
     */
    private Long codigo;
    private Long codigoServico;
    private Long codigoSessao;
    private Long codigoDivisao;
    private Long codigoSubclasse;
    private Long codigoCPC;

    private String nomeSessao;
    private String nomeDivisao;
    private String nomeGrupo;
    private String nomeSubclasse;
    private String nomeServicoAcentuado;
    private String descricaoServicoAcentuado;

    private Boolean status;
    private Boolean suspenso;
    private Boolean statusServico;
    private Boolean statusSessao;
    private Boolean statusDivisao;
    private Boolean statusClasse;
    private Boolean statusSubclasse;
    private Boolean indicadoItemSuspenso;
    private Boolean exclusivoCentralCompras;

}
