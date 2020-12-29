package Opdracht2;

import java.util.Arrays;
import java.util.LinkedList;

public class Gene {
    private Integer id;
    private String name;
    private LinkedList<String> altNames;
    private String chromosome;
    private String locus;
    private String geneFunction;
    private String productType;

    public Gene(String id, String name, String altNames) {
        this.id = Integer.valueOf(id);
        this.name = name;
        this.altNames = (LinkedList<String>) altNames.split("|");
        this.chromosome = chromosome;
        this.locus = locus;
        this.geneFunction = geneFunction;
        this.productType = productType;
    }
}
