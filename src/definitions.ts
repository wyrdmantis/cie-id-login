export interface CieIDLoginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  loginWithCieID(options: { value: string }): Promise<{ value: string }>;
}
