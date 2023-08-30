"use client";
import { bungee } from "@/app/components/navbar";
import ShortLinkBox from "@/app/components/shortLinkBox";
import { useEffect, useState } from "react";
import { useCustomQuery } from "@/hooks/useQuery";
import { useMutation } from "@tanstack/react-query";
import axios from "axios";

const UrlInputField = () => {
  const [userUrl, setUserUrl] = useState<string | null>(null);
  const [sortedUrl, setSortedUrl] = useState<string | null>(null);

  //const { mutate, isLoading, isError, data, error }=useCustomQuery();

  const { mutate, isLoading, isError, data, error } = useMutation(
    (data: any) => {
      return axios.post("http://localhost:8080/shorturl", {
        url: userUrl,
        owner: "imakhlaq",
      });
    },
    {
      onSuccess: ({ data }) => {
        console.log(data);
        setSortedUrl(data.shortURl);
      },
    },
  );

  if (isError) {
    // @ts-ignore
    console.log(error?.message);
  }

  if (isLoading) console.log("loading");

  return (
    <>
      <main className="container mx-auto max-w-6xl px-6 py-12 ">
        <form
          className={"flex flex-col gap-6 font-bold justify-center"}
          onSubmit={(event) => {
            event.preventDefault();
            mutate(userUrl);
          }}
        >
          <label htmlFor="link_url" className={bungee.className + " -mb-5"}>
            Shorten a long URL
          </label>
          <input
            type="text"
            className="h-10 text-black px-4 text-lg rounded shadow focus:outline-none focus:shadow-2xl placeholder:text-lg font-mediumt"
            placeholder="Past link here"
            id="link_url"
            value={userUrl ?? ""}
            onChange={(event) => setUserUrl(event.target.value)}
          />
          <div className={"flex justify-center"}>
            <button
              type="submit"
              className="h-10 bg-green-700 px-4 text-xl rounded shadow-lg min-w-[30%]"
            >
              Short Url
            </button>
          </div>
        </form>
      </main>
      <ShortLinkBox sortUrl={sortedUrl} isLoading={isLoading} />
    </>
  );
};
export default UrlInputField;
