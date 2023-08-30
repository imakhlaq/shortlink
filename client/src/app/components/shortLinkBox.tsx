"use client";
import { MdContentCopy } from "react-icons/md";
import { ToastContainer, toast } from "react-toastify";
import useClipboard from "@/hooks/useClipboard";
import "react-toastify/dist/ReactToastify.css";
import Link from "next/link";

type Props = {
  sortUrl: string | null;
  isLoading: boolean;
};
const ShortLinkBox = ({ sortUrl, isLoading }: Props) => {
  const setToClipBoard = useClipboard();

  if (!sortUrl || isLoading) return null;

  const clickHandler = async (e: React.MouseEvent<HTMLButtonElement>) => {
    e.preventDefault();
    await setToClipBoard(sortUrl);
    toast("Copied");
  };

  return (
    <section className="container mx-auto max-w-6xl px-6 py-8 text-2xl">
      <div className="flex justify-around bg-black items-center px-4 py-5 rounded">
        <Link href={sortUrl} className="text-xl">
          {sortUrl}
        </Link>
        <button className=" p-2 lg:p-6" onClick={clickHandler}>
          <MdContentCopy className="lg:w-20" />
        </button>
      </div>
      <ToastContainer
        position="top-right"
        autoClose={1000}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        theme="dark"
      />
    </section>
  );
};
export default ShortLinkBox;
