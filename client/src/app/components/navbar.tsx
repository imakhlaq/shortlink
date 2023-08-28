import { Bungee } from "next/font/google";
import Link from "next/link";

export const bungee = Bungee({ weight: "400", subsets: ["latin"] });

type Props = {};
const Navbar = (props: Props) => {
  return (
    <header className={"container mx-auto max-w-6xl px-6 py-8 text-2xl"}>
      <Link href={"/"}>
        <h1 className={bungee.className}>Short Link</h1>
      </Link>
    </header>
  );
};
export default Navbar;
