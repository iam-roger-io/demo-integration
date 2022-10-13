#stage 1
FROM node:16 as builder
WORKDIR /app

#ENV HTTP_PROXY ""
#ENV HTTPS_PROXY ""

COPY . .

RUN npm install -g @angular/cli
RUN npm install 
RUN ng build

#stage 2
FROM registry.access.redhat.com/ubi8/nginx-120:1-54
COPY nginx.conf "${NGINX_CONF_PATH}"
COPY --from=builder /app/dist/portal-front-angular .

CMD nginx -g "daemon off;"
