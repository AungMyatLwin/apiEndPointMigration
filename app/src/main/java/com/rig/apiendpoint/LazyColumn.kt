package com.rig.apiendpoint

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ReuseLazyColum(list: List<Entry>) {
    LazyColumn{
      items(list){
            Card(modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
                elevation = CardDefaults.elevatedCardElevation(4.dp)){
                Column(modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()) {
                    Text(text = "Api: \t"+it.API, color = Color.Cyan)
                    Text(text = "Des: \t"+it.Description, color = Color.Magenta)
                    Text(text = "Category: \t"+it.Category, color = Color.Red)
                    Text(text = "Url: \t"+it.Link, color = Color.Blue)
                }
            }
        }
    }
}