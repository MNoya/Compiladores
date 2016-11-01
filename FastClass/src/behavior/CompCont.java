package behavior;

import ast.Programa;
import java.util.*;

public class CompCont {

    public final List<String> variables = new ArrayList();
    public final StringBuilder code = new StringBuilder();

    public CompCont(Programa prog) {
        this(new HashSet<String>());
    }

    public CompCont(Collection<String> variables) {
        this.variables.addAll(variables);
    }
}
