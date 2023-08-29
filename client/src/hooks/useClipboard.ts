export default function useClipboard() {
  return (message: string) => navigator.clipboard.writeText(message);
}
