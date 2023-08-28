import { bungee } from "@/app/components/navbar";

type Props = {};
const Input = (props: Props) => {
  return (
    <main className="container mx-auto max-w-6xl px-6 py-12 ">
      <form className={"flex flex-col gap-6 font-bold justify-center"}>
        <label htmlFor={"link"} className={bungee.className + " -mb-5"}>
          Shorten a long URL
        </label>
        <input
          type="text"
          className="h-10 text-black px-4 text-xl rounded shadow focus:outline-none focus:shadow-2xl"
          name={"enter_link"}
          id={"link"}
        />
        <div className={"flex justify-center"}>
          <button
            type="submit"
            className={
              "h-10 bg-green-700 px-4 text-xl rounded shadow-lg min-w-[30%]"
            }
          >
            Short Url
          </button>
        </div>
      </form>
    </main>
  );
};
export default Input;