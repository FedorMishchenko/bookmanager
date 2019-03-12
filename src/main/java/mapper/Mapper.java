package mapper;

/**
 * @param <FROM> DtoObject
 * @param <TO>  EntityObject
 */
public interface Mapper<FROM,TO> {

    TO mapToObject(FROM origin);

    FROM mapToDto(TO object);
}
