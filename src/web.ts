import { WebPlugin } from '@capacitor/core';

import type { CieIDLoginPlugin } from './definitions';
import * as console from 'node:console';

export class CieIDLoginWeb extends WebPlugin implements CieIDLoginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  loginWithCieID(options: { value: string }): Promise<{ value: string }> {
    return Promise.resolve({ value: options.value });
  }
}
