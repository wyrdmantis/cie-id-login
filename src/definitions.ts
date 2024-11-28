export interface CieIDLoginPlugin {
  loginWithCieID(options: { value: string }): Promise<{ value: string }>;
}
