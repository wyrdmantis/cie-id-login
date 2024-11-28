import { WebPlugin } from '@capacitor/core';

import type { CieIDLoginPlugin } from './definitions';

export class CieIDLoginWeb extends WebPlugin implements CieIDLoginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
