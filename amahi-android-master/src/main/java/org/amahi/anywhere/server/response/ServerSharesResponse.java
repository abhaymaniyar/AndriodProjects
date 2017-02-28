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

import org.amahi.anywhere.bus.BusProvider;
import org.amahi.anywhere.bus.ServerSharesLoadFailedEvent;
import org.amahi.anywhere.bus.ServerSharesLoadedEvent;
import org.amahi.anywhere.server.model.ServerShare;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Shares response proxy. Consumes API callback and posts it via {@link com.squareup.otto.Bus}
 * as {@link org.amahi.anywhere.bus.BusEvent}.
 */
public class ServerSharesResponse implements Callback<List<ServerShare>>
{
	@Override
	public void success(List<ServerShare> serverShares, Response response) {
		BusProvider.getBus().post(new ServerSharesLoadedEvent(serverShares));
	}

	@Override
	public void failure(RetrofitError error) {
		BusProvider.getBus().post(new ServerSharesLoadFailedEvent());
	}
}
