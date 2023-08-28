package dev.marksduarte.cnbsserproclient.api.cnbs;

import dev.marksduarte.cnbsserproclient.api.cnbs.domain.caracteristica.CnbsSerproCaracteristica;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.item.CnbsSerproItem;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.material.CnbsSerproClassificacaoContabilMaterial;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.material.CnbsSerproMaterial;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.servico.CnbsSerproClassificacaoContabilServico;
import dev.marksduarte.cnbsserproclient.api.cnbs.domain.servico.CnbsSerproServico;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Log4j2
@RestController
@RequestMapping(value = "/")
public class CnbsSerproResource {

    @Autowired
    private CnbsSerproService service;

    @GetMapping("itens")
    public ResponseEntity<List<CnbsSerproItem>> getItens(@Valid CnbsSerproSearchFilter searchFilter) {
        return ResponseEntity.ok(service.getItens(searchFilter));
    }

    @GetMapping("materiais")
    public ResponseEntity<List<CnbsSerproMaterial>> getMateriais(@Valid CnbsSerproSearchFilter searchFilter) {
        return ResponseEntity.ok(service.getMateriais(searchFilter));
    }

    @GetMapping("materiais-por-pdm")
    public ResponseEntity<List<CnbsSerproMaterial>> getMateriaisComCaracteristicasPorPdm(@Valid CnbsSerproSearchFilter searchFilter) {
        return ResponseEntity.ok(service.getMateriaisPorPdm(searchFilter));
    }

    @GetMapping("materiais/caracteristicas-por-pdm")
    public ResponseEntity<List<CnbsSerproCaracteristica>> getCaracteristicasPorPdm(@Valid CnbsSerproSearchFilter searchFilter) {
        return ResponseEntity.ok(service.getCaracteristicasPorPdm(searchFilter));
    }

    @GetMapping("materiais/classificacao-contabil")
    public ResponseEntity<List<CnbsSerproClassificacaoContabilMaterial>> getClassificacoesContabeisMaterial(@Valid CnbsSerproSearchFilter searchFilter) {
        return ResponseEntity.ok(service.getClassificacoesContabeisMaterial(searchFilter));
    }

    @GetMapping("servicos")
    public ResponseEntity<List<CnbsSerproServico>> getServicos(@Valid CnbsSerproSearchFilter searchFilter) {
        return ResponseEntity.ok(service.getServicos(searchFilter));
    }

    @GetMapping("servicos/classificacao-contabil")
    public ResponseEntity<List<CnbsSerproClassificacaoContabilServico>> getClassificacoesContabeisServico(@Valid CnbsSerproSearchFilter searchFilter) {
        return ResponseEntity.ok(service.getClassificacoesContabeisServico(searchFilter));
    }


}
