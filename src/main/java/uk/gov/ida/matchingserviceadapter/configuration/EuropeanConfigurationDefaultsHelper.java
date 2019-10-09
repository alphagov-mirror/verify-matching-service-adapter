package uk.gov.ida.matchingserviceadapter.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.eclipse.jetty.util.TypeUtil.asList;

public class EuropeanConfigurationDefaultsHelper {

    private static final String[] ACCEPTABLE_HUB_CONNECTOR_ENTITY_IDS_PRODUCTION = new String[] {
        "https://www.signin.service.gov.uk/SAML2/metadata/connector",               // (AWS)
        "https://connector-node.london.verify.govsvc.uk/ConnectorMetadata",         // (GSP)
        "https://eidas.signin.service.gov.uk/ConnectorMetadata",                    // (potential new #1)
        "https://connector.eidas.signin.service.gov.uk/ConnectorMetadata",          // (potential new #2)
        "https://connector-node.eidas.signin.service.gov.uk/ConnectorMetadata",     // (potential new #3)
    };

    private static final String[] ACCEPTABLE_HUB_CONNECTOR_ENTITY_IDS_INTEGRATION = new String[]{
        "https://www.integration.signin.service.gov.uk/SAML2/metadata/connector",               // (AWS)
        "https://connector-node-integration.london.verify.govsvc.uk/ConnectorMetadata",         // (GSP)
        "https://eidas.integration.signin.service.gov.uk/ConnectorMetadata",                    // (potential new #1)
        "https://connector.eidas.integration.signin.service.gov.uk/ConnectorMetadata",          // (potential new #2)
        "https://connector-node.eidas.integration.signin.service.gov.uk/ConnectorMetadata",     // (potential new #3)
    };

    public static List<String> getDefaultAcceptableHubConnectorEntityIds(MatchingServiceAdapterEnvironment environment) {
        switch (environment) {
            case INTEGRATION:
                return asList(ACCEPTABLE_HUB_CONNECTOR_ENTITY_IDS_INTEGRATION);
            case PRODUCTION:
                return asList(ACCEPTABLE_HUB_CONNECTOR_ENTITY_IDS_PRODUCTION);
            default:
                throw new IllegalArgumentException(environment.name());
        }
    }

}
