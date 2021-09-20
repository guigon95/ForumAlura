package br.com.guigon95.ForumAlura.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.guigon95.ForumAlura.modelo.Usuario;
import br.com.guigon95.ForumAlura.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> usuario = repository.findByEmail(username);

		System.out.println("loadUserByUsername");
		if (usuario.isPresent()) {
			usuario.get();
			System.out.println("usuario get: " + usuario.get().getEmail());
			System.out.println("usuario get: " + usuario.get().getSenha());
			System.out.println("usuario get: " + usuario.get().getPassword());
			usuario.get().getAuthorities().forEach(c -> c.getAuthority());
			return User.builder().username(usuario.get().getEmail()).password(usuario.get().getSenha()).build();
		}

		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
