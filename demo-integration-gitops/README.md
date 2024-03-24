# GitOps Demo Integration Project


Execução manual

```
cd demo-integration

oc new-project demo-integration

helm install demo-integration-package ./demo-integration-gitops

./demo-integration-backend/database/demointegrationdb.sql
```

Para carregar schema da base de dados, contulte o item [Iniciar base de dados  no arquivo README.md](../demo-integration-backend/README.md) no do projeto demo-integration-backend