/*
 * Copyright (c) 2014 Amahi
 *
 * This file is part of Amahi.
 *
 * Amahi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Amahi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Amahi. If not, see <http ://www.gnu.org/licenses/>.
 */

package org.amahi.anywhere.server.response;

import org.amahi.anywhere.bus.AuthenticationConnectionFailedEvent;
import org.amahi.anywhere.bus.AuthenticationFailedEvent;
import org.amahi.anywhere.bus.AuthenticationSucceedEvent;
import org.amahi.anywhere.bus.BusProvider;
import org.amahi.anywhere.server.model.Authentication;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Authentication response proxy. Consumes API callback and posts it via {@link com.squareup.otto.Bus}
 * as {@link org.amahi.anywhere.bus.BusEvent}.
 */
public class AuthenticationResponse implements Callback<Authentication>
{
	@Override
	public void success(Authentication authentication, Response response) {
		BusProvider.getBus().post(new AuthenticationSucceedEvent(authentication));
	}

	@Override
	public void failure(RetrofitError error) {
		if (error.isNetworkError()) {
			BusProvider.getBus().post(new AuthenticationConnectionFailedEvent());
		} else {
			BusProvider.getBus().post(new AuthenticationFailedEvent());
		}
	}
}
