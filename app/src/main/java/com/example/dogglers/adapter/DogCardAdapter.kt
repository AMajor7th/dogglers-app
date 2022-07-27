/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout.GRID
import com.example.dogglers.data.DataSource

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val imageView = view?.findViewById<ImageView>(R.id.image_item)
        val nameText = view?.findViewById<TextView>(R.id.name_item)
        val ageText = view?.findViewById<TextView>(R.id.age_item)
        val hobbiesText = view?.findViewById<TextView>(R.id.hobbies_item)
        // TODO: Declare and initialize all of the list item UI components(DONE)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val listItemLayout = if (layout == GRID) R.layout.grid_list_item else R.layout.vertical_horizontal_list_item
        val adapterLayout = LayoutInflater.from(parent.context).inflate(listItemLayout, parent, false)
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = DataSource.dogs.size // TODO: return the size of the data set instead of 0(DONE)

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dog = DataSource.dogs[position]
        holder.imageView?.setImageResource(dog.imageResourceId)
        holder.nameText?.text = dog.name
        val resources = context?.resources
        holder.ageText?.text = resources?.getString(R.string.dog_age, dog.age)
        holder.hobbiesText?.text = resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
