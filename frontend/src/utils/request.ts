// import.meta.env.VITE_BACKEND_URL -> Pega a variavel de ambiente por padrao
// se nao tiver a variavel pega o que esta a direita do ?? 

export const BASE_URL = import.meta.env.VITE_BACKEND_URL ?? "http://localhost:8080";