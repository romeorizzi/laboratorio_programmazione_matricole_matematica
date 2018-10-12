#!/bin/bash

pip3 install --user -U jupyter ipython==6 prompt_toolkit==1.0.15

echo 'export PATH=$PATH:$HOME/.local/bin' >> ~/.bashrc

source ~/.bashrc

echo 'Inizia ad usare ipython digitando il comando ipython'   
