package gsohz.web.api.controller;

import gsohz.web.api.model.Usuario;
import gsohz.web.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> getAll(){
        return repository.listAll();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return repository.finByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.remove(id);
    }

    @PostMapping
    public void post(@RequestBody Usuario usuario){
        repository.save(usuario);
    }

    @PutMapping
    public void put(@RequestBody Usuario usuario){
        repository.update(usuario);
    }
}
