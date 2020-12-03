package kr.co.ubcn.welpoint.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class User {

    public String userId;

    public String password;

    public String email;

    public String name;

    public int companySeq;
}
