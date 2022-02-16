package mx.com.gm.HolaSpring.Servicio;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.HolaSpring.DAO.UsuarioDAO;
import mx.com.gm.HolaSpring.Domain.Rol;
import mx.com.gm.HolaSpring.Domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioDAO usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUserName(userName);

        if(usuario == null){
            throw new UsernameNotFoundException(userName);
        }

        var roles = new ArrayList<GrantedAuthority>();

        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }

        return new User(usuario.getUserName(), usuario.getPassword(), roles);
    }

}
