/*
 * Copyright 2012 GitHub Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.mobile.ui.user;

import android.view.LayoutInflater;
import android.view.View;

import com.github.mobile.ui.ItemListAdapter;
import com.github.mobile.util.AvatarLoader;
import com.github.mobile.R.layout;

import java.util.List;

import org.eclipse.egit.github.core.User;

/**
 * List adapter for a list of users
 */
public class UserListAdapter extends ItemListAdapter<User, UserItemView> {

    private final AvatarLoader avatars;

    /**
     * Create user list adapter
     *
     * @param inflater
     * @param elements
     * @param avatars
     */
    public UserListAdapter(final LayoutInflater inflater,
            final List<User> elements, final AvatarLoader avatars) {
        super(layout.user_item, inflater, elements);

        this.avatars = avatars;
    }

    /**
     * Create user list adapter
     *
     * @param inflater
     * @param avatars
     */
    public UserListAdapter(final LayoutInflater inflater,
            final AvatarLoader avatars) {
        this(inflater, null, avatars);
    }

    @Override
    protected void update(final int position, final UserItemView view,
            final User user) {
        avatars.bind(view.avatarView, user);
        view.loginText.setText(user.getLogin());
    }

    @Override
    protected UserItemView createView(final View view) {
        return new UserItemView(view);
    }

    @Override
    public long getItemId(final int position) {
        return getItem(position).getId();
    }
}
