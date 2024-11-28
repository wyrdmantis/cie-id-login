import { registerPlugin } from '@capacitor/core';

import type { CieIDLoginPlugin } from './definitions';

const CieIDLogin = registerPlugin<CieIDLoginPlugin>('CieIDLogin', {
  web: () => import('./web').then((m) => new m.CieIDLoginWeb()),
});

export * from './definitions';
export { CieIDLogin };
