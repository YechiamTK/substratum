/*
 * Copyright (c) 2016-2017 Projekt Substratum
 * This file is part of Substratum.
 *
 * Substratum is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Substratum is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Substratum.  If not, see <http://www.gnu.org/licenses/>.
 */

package projekt.substratum.common.platform;

import android.os.RemoteException;

import java.util.List;

import projekt.andromeda.IAndromedaInterface;
import projekt.substratum.services.binder.AndromedaBinderService;

public class AndromedaService {

    static IAndromedaInterface getAndromedaInterface() {
        return AndromedaBinderService.getInstance().getAndromedaInterface();
    }

    public static boolean checkServerActivity() {
        try {
            return getAndromedaInterface().checkServerActivity();
        } catch (RemoteException e) {
            // Suppress warning
        }
        return false;
    }

    static boolean enableOverlays(List<String> overlays) {
        try {
            return getAndromedaInterface().enableOverlay(overlays);
        } catch (RemoteException e) {
            // Suppress warning
        }
        return false;
    }

    static boolean disableOverlays(List<String> overlays) {
        try {
            return getAndromedaInterface().disableOverlay(overlays);
        } catch (RemoteException e) {
            // Suppress warning
        }
        return false;
    }

    public static boolean listOverlays() {
        try {
            return getAndromedaInterface().listOverlays();
        } catch (RemoteException e) {
            // Suppress warning
        }
        return false;
    }

    static boolean installOverlays(List<String> overlays) {
        try {
            return getAndromedaInterface().installPackage(overlays);
        } catch (RemoteException e) {
            // Suppress warning
        }
        return false;
    }

    static boolean uninstallOverlays(List<String> overlays) {
        try {
            return getAndromedaInterface().uninstallPackage(overlays);
        } catch (RemoteException e) {
            // Suppress warning
        }
        return false;
    }

    static boolean setPriority(List<String> overlays) {
        try {
            return getAndromedaInterface().changePriority(overlays);
        } catch (RemoteException e) {
            // Suppress warning
        }
        return false;
    }
}