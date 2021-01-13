package _model;

import java.util.List;

public class OperatingStates {

	public class Pagination{
	    public int offset;
	    public int count;
	    public int limit;
	    public Object lastIdentifier;
	    public Object firstIdentifier;
	    public int total;
	}

	public class Properties{
	    public String id;
	    public String description;
	    public String shortDescription;
	    public String code;
	    public String color;
	    public boolean isRecodable;
	    public boolean isSplittable;
	    public boolean isAnnotatable;
	    public String customerCode;
	    public String workplaceStateId;
	    public String operatingStateClassId;
	}

	public class OperatingState{
	    public Properties properties;
	}

	public class Embedded{
	    public List<OperatingState> operatingStates;
	}

	public class Root{
	    public Pagination pagination;
	    public Embedded _embedded;
	}
}
