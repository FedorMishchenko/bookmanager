package dto.dtohandler;

import dto.EntityDto;

public abstract class DtoHandler <Type, Con>{

    public abstract EntityDto init();

    public abstract Type transfer(Con controller);

}
