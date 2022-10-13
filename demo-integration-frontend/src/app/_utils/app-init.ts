import { KeycloakOptions, KeycloakService } from 'keycloak-angular';
import { ConfigurationsService } from '../_services/configurations.service';


export function initializer(keycloak: KeycloakService, loadConfigService:ConfigurationsService): () => Promise<any> {
  return (): Promise<any> => {
    return new Promise(async (resolve, reject) => {
      
      //serviço de configurações
      await loadConfigService.load();

      //serviço do keycloak
      try {
        await keycloak.init({
            config: {
              url: loadConfigService.settings.keycloakUrl,
              realm: loadConfigService.settings.realm,
              clientId: loadConfigService.settings.clientId,
            },
            initOptions: {
              onLoad: 'check-sso',
              silentCheckSsoRedirectUri:
                window.location.origin + '/assets/silent-check-sso.html'
            }
          });
        resolve(false);
      } catch (error) {
        reject(error);
      }
    });
  };
}
