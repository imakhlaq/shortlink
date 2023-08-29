import { useMutation } from "@tanstack/react-query";
import { request } from "@/utils/service";
import axios from "axios";

function mutateFn(data: any) {
  return request({ url: "/register/url", method: "POST", data: data });
}

export const useCustomQuery = () => {
  return useMutation(mutateFn, {});
};
