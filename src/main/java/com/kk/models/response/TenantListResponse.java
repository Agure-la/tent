package com.kk.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TenantListResponse {

    @JsonProperty("tenants")
    private List<TenantResponse> tenants;

    public List<TenantResponse> getTenants() {
        return tenants;
    }

    public void setTenants(List<TenantResponse> tenants) {
        this.tenants = tenants;
    }
}
