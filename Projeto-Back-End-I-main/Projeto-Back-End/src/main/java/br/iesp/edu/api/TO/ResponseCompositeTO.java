package br.iesp.edu.api.TO;


import java.util.ArrayList;

public class ResponseCompositeTO {

    public class ResponseBodyTO{
      public   ArrayList<CompositeResponseTO> compositeResponse;
    }

    public class CompositeResponseTO{
        public BodyTO body;
    }

    public class BodyTO {
        public String id;
    }

}
