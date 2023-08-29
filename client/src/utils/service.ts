import axios from "axios";

export const baseURL = "http://localhost:8080";

const client = axios.create({
  baseURL,
});

export const request = ({ ...options }: any) => {
  //access client and set stuff
  client.defaults.headers.common["Content-Type"] = "application/json";
  const onSuccess = (response: any) => response;

  const onError = (error: any) => {
    return error;
  };

  return client(options).then(onSuccess).catch(onError);
};

//XMKwZU8Q8b
