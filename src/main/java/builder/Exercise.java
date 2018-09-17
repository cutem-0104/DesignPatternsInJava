package builder;

import java.util.ArrayList;

class CodeBuilder
{
    String className;
    public ArrayList<Property> propertys = new ArrayList<>();

    public CodeBuilder(String className)
    {
        // todo
        this.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        // todo
        Property property = new Property(name, type);
        propertys.add(property);
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        // todo
        sb.append("public class " + className + "\n");
        sb.append("{\n");
        for (Property p : propertys) {
            sb.append("  public " + p.type + " " + p.name + ";\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}

class Property {
    public String name;
    public String type;

    public Property(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

class d{
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("name", "String");
        System.out.println(cb);
    }
}
