package edu.gsohz.padroes_projeto_spring.controller;

import edu.gsohz.padroes_projeto_spring.handler.CampoObrigatorioException;
import edu.gsohz.padroes_projeto_spring.model.Cliente;
import edu.gsohz.padroes_projeto_spring.model.Endereco;
import edu.gsohz.padroes_projeto_spring.model.dto.ClienteCadastroDto;
import edu.gsohz.padroes_projeto_spring.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody ClienteCadastroDto clienteDto) {
        if(clienteDto.getNome() == null
                || clienteDto.getNome().isEmpty()
                || clienteDto.getNome().isBlank())
            throw new CampoObrigatorioException("Nome");

        if(clienteDto.getCep() == null
                || clienteDto.getCep().isEmpty()
                || clienteDto.getCep().isBlank())
            throw new CampoObrigatorioException("CEP");

        Cliente cliente = convertToEntity(clienteDto);
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }

    private ClienteCadastroDto convertToDto (Cliente cliente){
        ClienteCadastroDto clienteCadastroDto = modelMapper.map(cliente, ClienteCadastroDto.class);
        clienteCadastroDto.setCep(cliente.getEndereco().getCep());
        return clienteCadastroDto;
    }

    private Cliente convertToEntity (ClienteCadastroDto clienteCadastroDto){
        Cliente cliente = modelMapper.map(clienteCadastroDto, Cliente.class);
        Endereco endereco = new Endereco();
        endereco.setCep(clienteCadastroDto.getCep());
        cliente.setEndereco(endereco);
        return cliente;
    }
}