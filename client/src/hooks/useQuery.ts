import { useMutation } from "@tanstack/react-query";
import { request } from "@/utils/service";
import axios from "axios";

function mutateFn(data: any) {
  return request({
    url: "/sorturl",
    method: "POST",
    data: {
      url: data.url,
      owner: null,
    },
  });
}

export const useCustomQuery = () => {
  return useMutation(mutateFn, {});
};
