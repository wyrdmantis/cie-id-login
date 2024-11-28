import { WebPlugin } from '@capacitor/core';

import type { CieIDLoginPlugin } from './definitions';

export class CieIDLoginWeb extends WebPlugin implements CieIDLoginPlugin {

  loginWithCieID(options: { value: string }): Promise<{ value: string }> {
    return Promise.resolve({ value: options.value });
  }
}
