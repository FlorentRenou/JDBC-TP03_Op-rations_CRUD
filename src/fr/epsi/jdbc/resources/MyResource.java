package fr.epsi.jdbc.resources;

public class MyResource implements AutoCloseable {

    private String name;

    public MyResource( String name ) {
        this.name = name;
    }

    @Override
    public void close() throws Exception {
        System.out.println( "libération de la ressource " + name + "!!!" );
    }
}
