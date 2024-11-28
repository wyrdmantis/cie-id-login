export interface CieIDLoginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
