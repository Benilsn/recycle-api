package com.recycle.Recycle.DTO;

import com.recycle.Recycle.models.Client;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientDTO {

    private Integer client_id;

    private String first_name;

    private String last_name;

    private int age;

    private String email;

    private String user_role;

    private String user_name;

    private String user_password;

    public static ClientDTO convert(Client c){

        ClientDTO clientdto = new ClientDTO();

        clientdto.setClient_id(c.getClient_id());
        clientdto.setFirst_name(c.getFirst_name());
        clientdto.setLast_name(c.getLast_name());
        clientdto.setAge(c.getAge());
        clientdto.setEmail(c.getEmail());
        clientdto.setUser_role(c.getUser_role());
        clientdto.setUser_name(c.getUser_name());
        clientdto.setUser_password(c.getUser_password());

        return clientdto;
    }
}
