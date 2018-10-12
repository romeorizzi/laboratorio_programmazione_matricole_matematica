#!/bin/bash

pip3 install --user -U ipython==6 prompt_toolkit==1.0.15
pip3 install --user -U jupyter 
pip3 install --user -U ipython==6 prompt_toolkit==1.0.15

echo 'export PATH=$PATH:$HOME/.local/bin' >> ~/.bashrc

source ~/.bashrc

echo 'Installazione completata'
echo 'Per utilizzare ipython digita il comando: ipython'
echo 'Per avviare un notebook digita il comando: jupyter notebook &'
