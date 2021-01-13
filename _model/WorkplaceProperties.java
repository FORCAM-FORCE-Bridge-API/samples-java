package _model;

import java.util.Date;
import java.util.List;

public class WorkplaceProperties {
	
	public class CapacityGroup{
	    public String id;
	    public String number;
	    public String description;
	    public String type;
	    public String erpContextId;
	}

	public class ProductionLine{
	    public String id;
	    public String number;
	    public String description;
	    public String type;
	    public String erpContextId;
	}

	public class OperatingState{
	    public String id;
	    public String description;
	    public String code;
	    public String workplaceStateId;
	}

	public class Properties{
	    public String id;
	    public String number;
	    public String description;
	    public String erpContextId;
	    public CapacityGroup capacityGroup;
	    public ProductionLine productionLine;
	    public OperatingState operatingState;
	    public String workplaceType;
	}

	public class Workplace{
	    public String _embedded;
	    public String _links;
	    public Properties properties;
	}

	public class Embedded{
	    public List<Workplace> workplaces;
	}

	public class FirstIdentifier{
	    public String identifier;
	    public Date timestamp;
	}

	public class LastIdentifier{
	    public String identifier;
	    public Date timestamp;
	}

	public class Pagination{
	    public int count;
	    public FirstIdentifier firstIdentifier;
	    public LastIdentifier lastIdentifier;
	    public int limit;
	    public int offset;
	    public int total;
	}

	public class Root{
	    public Embedded _embedded;
	    public String _links;
	    public Pagination pagination;
	}	
}
