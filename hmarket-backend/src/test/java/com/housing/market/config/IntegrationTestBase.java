package com.housing.market.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ApiIntegrationTest
@ExtendWith(SpringExtension.class)
public abstract class IntegrationTestBase {

    @Autowired
    protected MockMvc mvc;

}
