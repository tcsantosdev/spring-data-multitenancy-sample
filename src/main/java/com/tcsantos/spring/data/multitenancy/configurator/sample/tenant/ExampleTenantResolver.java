package com.tcsantos.spring.data.multitenancy.configurator.sample.tenant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tcsantos.spring.data.multitenancy.Tenant;
import com.tcsantos.spring.data.multitenancy.TenantResolver;

@Service
public class ExampleTenantResolver implements TenantResolver {

	private Tenant defaultTenant;

	@PostConstruct
	public void init() {
		createDefaultTenant();
	}

	@Override
	public Collection<Tenant> resolveAllTenants() {
		List<Tenant> tenants = new ArrayList<>();

		tenants.add(createTenant("tenant1"));
		tenants.add(createTenant("tenant2"));

		return tenants;
	}

	@Override
	public Tenant resolveCurrentTenant() {

		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

			String requestURI = request.getRequestURI();

			String identifier = requestURI.split("/")[2];

			return createTenant(identifier);

		} catch (Exception e) {
			return defaultTenant;
		}

	}

	@Override
	public String resolveTenantSchemaName(String identifier) {
		return resolveCurrentTenant().getSchemaName();
	}

	private void createDefaultTenant() {
		defaultTenant = createTenant("public");
	}

	private Tenant createTenant(String identifier) {
		Tenant tenant = new Tenant();

		tenant.setIdentifier(identifier);
		tenant.setSchemaName(identifier);
		return tenant;
	}

}
