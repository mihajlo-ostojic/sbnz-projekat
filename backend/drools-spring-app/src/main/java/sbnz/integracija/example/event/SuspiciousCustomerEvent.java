package sbnz.integracija.example.event;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
@Expires("30d")
public class SuspiciousCustomerEvent {

	public int customerId;
    public String reason;
	public SuspiciousCustomerEvent(int customerId, String reason) {
		super();
		this.customerId = customerId;
		this.reason = reason;
	}
	public SuspiciousCustomerEvent() {
		super();
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
    
}
