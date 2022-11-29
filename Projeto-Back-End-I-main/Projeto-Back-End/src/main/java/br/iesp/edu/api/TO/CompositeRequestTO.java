package br.iesp.edu.api.TO;

import java.util.ArrayList;

public class CompositeRequestTO {

    public static class CompositeTO{
        public ArrayList<CompositeAttRequestTO> compositeRequest;
    }

    public static class CompositeAttRequestTO{
        public String method;
        public String url;
        public String referenceId;
        public Object body;
    }
}
